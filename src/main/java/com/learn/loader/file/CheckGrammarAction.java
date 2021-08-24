package com.learn.loader.file;

import com.learn.loader.file.report.ReportBody;
import com.learn.loader.file.report.ReportItem;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckGrammarAction {

    private final GrammarBodIntegration grammarBot;
    private XSSFWorkbook workbook;

    public CheckGrammarAction() {
        grammarBot = new GrammarBodIntegration();
    }

    public void check(File file) {
        setWorkbook(file);
        final List<String> strings = mapToStrings(workbook);
        final Map<String, String> errors = new HashMap<>();
        for (String text : strings) {
            List<ReportBody> reports = grammarBot.sendTextToCheck(text, LANGUAGES.EN_US);
            reports.forEach(rep -> {
                if (!rep.getMatches().isEmpty()) {
                    final String errMessage = rep.getMatches().stream().map(ReportItem::getMessage).collect(Collectors.joining("; "));
                    errors.put(text, errMessage);
                }
            });
        }
        fillReport(workbook, errors);
        try (OutputStream out = new FileOutputStream("res_" + file.getName())) {
            workbook.write(out);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setWorkbook(File workbook) {
        try {
            this.workbook = new XSSFWorkbook(workbook);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    private List<String> mapToStrings(XSSFWorkbook workbook) {
        final XSSFSheet sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());
        final int lastRowNum = sheet.getLastRowNum();

        List<String> result = new ArrayList<>();

        for (int i = 0; i <= lastRowNum; i++) {
            final XSSFRow row = sheet.getRow(i);
            final XSSFCell cell = row.getCell(0);
            if (cell != null) {
                final String value = cell.getStringCellValue();
                if (value != null && !value.isEmpty()) {
                    result.add(value);
                }
            }
        }
        return result;
    }

    private void fillReport(XSSFWorkbook workbook, Map<String, String> errors) {
        final XSSFSheet sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());
        sheet.autoSizeColumn(1);
        final int lastRowNum = sheet.getLastRowNum();

        for (int i = 0; i <= lastRowNum; i++) {
            final XSSFRow row = sheet.getRow(i);
            final XSSFCell cell = row.getCell(0);
            if (cell != null) {
                final String value = cell.getStringCellValue();
                final String errMess = errors.get(value);
                if (value != null && !value.isEmpty() && errMess != null && !errMess.isEmpty()) {
                    XSSFCell secondCell = row.getCell(1);
                    if (secondCell == null) {
                        secondCell = row.createCell(1);
                    }
                    secondCell.setCellValue(errMess);
                }
            }
        }
    }
}