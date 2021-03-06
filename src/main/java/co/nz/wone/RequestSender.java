package co.nz.wone;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class RequestSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Logger.class);
    private final RequestSpecification requestSpecification;
    private final String url;
    private final CrudEnum crudEnum;

    /**
     * Send the requests.
     * @return
     */
    public Response send() {
        LOGGER.debug("======= [START Request] {} ===========");
        Response response = crudEnum.sendRequest(this.requestSpecification, url);
        LOGGER.debug("======= [END Request] {} ===========");
        return response;
    }

}
