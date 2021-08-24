package com.learn.loader.file;

import com.learn.loader.file.report.ReportBody;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GrammarBodIntegration {

    private final ResponseMapper mapper = new ResponseMapper();

    public List<ReportBody> sendTextToCheck(String text, LANGUAGES lang) {
        List<ReportBody> result = new ArrayList<>();

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, String.format("text=%s&language=%s", text, lang.getValue()));

        Request request = new Request.Builder()
                .url("https://grammarbot.p.rapidapi.com/check")
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("x-rapidapi-host", "grammarbot.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "cea1cee8e8msh067f3b8cc0d06eap1772fejsnfbcb060856d4")
                .build();

        try {
            Response response = client.newCall(request).execute();
            Optional<ReportBody> oRep = mapper.mapToReport(response);
            oRep.ifPresent(result::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}