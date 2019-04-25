package co.nz.wone;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

public enum CrudEnum {

    GET {
        @Override
        protected Response sendRequest(RequestSender requestSender, String url) {
            return requestSender.get(url);
        }
    },
    DELETE() {
        @Override
        protected Response sendRequest(RequestSender requestSender, String url) {
            return requestSender.delete(url);
        }
    },
    PUT() {
        @Override
        protected Response sendRequest(RequestSender requestSender, String url) {
            return requestSender.put(url);
        }
    },
    POST() {
        @Override
        protected Response sendRequest(RequestSender requestSender, String url) {
            return requestSender.post(url);
        }
    };

    protected abstract Response sendRequest(RequestSender requestSender, String url);

}

