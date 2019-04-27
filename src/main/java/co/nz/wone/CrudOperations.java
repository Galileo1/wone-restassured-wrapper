package co.nz.wone;

public class CrudOperations {

    private CrudEnum crudEnum;

    /**
     * Performs a POST request to a service.
     *
     * @return The context of this class.
     */
    public CrudOperations post() {
        this.crudEnum = CrudEnum.POST;
        return this;
    }

    /**
     * Performs a GET request to a service.
     *
     * @return The context of this class.
     */
    public CrudOperations get() {
        this.crudEnum = CrudEnum.GET;
        return this;
    }

    /**
     * Performs a DELETE request to a service.
     *
     * @return The context of this class.
     */
    public CrudOperations delete() {
        this.crudEnum = CrudEnum.DELETE;
        return this;
    }

    /**
     * Performs a DELETE request to a service.
     *
     * @return The context of this class.
     */
    public CrudOperations put() {
        this.crudEnum = CrudEnum.PUT;
        return this;
    }

    /**
     * Specify the url for the service to which request needs to be sent.
     *
     * @return The instance of Request Specs class.
     */
    public RequestSpecs usingURL(String url) {
        return new RequestSpecs(url, this.crudEnum);
    }


}
