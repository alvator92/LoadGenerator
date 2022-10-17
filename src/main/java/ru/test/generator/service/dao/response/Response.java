package ru.test.generator.service.dao.response;

import java.sql.Timestamp;
import java.util.Date;

public class Response {

    public Response() {
    }

    private int id;
    private int status;
    private String oper_code;
    private String oper_name;
    private String personal_id;
    private String owner_id;
    private Date reg_time;

    public static class Builder {
        private Response response;
        public Builder() {
            response = new Response();
        }
        public Builder withId(int var) {
            response.id = var;
            return this;
        }
        public Builder withStatus(int var) {
            response.status = var;
            return this;
        }
        public Builder withOperCode(String var) {
            response.oper_code = var;
            return this;
        }
        public Builder withOperName(String var) {
            response.oper_name = var;
            return this;
        }
        public Builder withPersonalId(String var) {
            response.personal_id = var;
            return this;
        }
        public Builder withOwnerId(String var) {
            response.owner_id = var;
            return this;
        }
        public Builder withRegTime(Date var) {
            response.reg_time = var;
            return this;
        }
        public Response build() {
            return response;
        }
    }
}
