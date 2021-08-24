package com.learn.loader.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.learn.loader.file.report.ReportBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Optional;

public class ResponseMapper {

    private final ObjectMapper mapper = new ObjectMapper();

    public Optional<ReportBody> mapToReport(Response response) {
        String stringBody;
        try {
            final ResponseBody respBody = response.body();
            if (respBody != null) {
                stringBody = respBody.string();
                final ObjectReader reader = mapper.reader();
                final ReportBody reportBody = reader.readValue(stringBody, ReportBody.class);
                return Optional.of(reportBody);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}
