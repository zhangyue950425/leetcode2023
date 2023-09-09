package spring.ioc;

public class BService {

    private AService aService;
    public BService() { }
    public BService(AService aService) {
        this.aService = aService;
    }
    public AService getaService() {
        return aService;
    }
    public void setaService(AService aService) {
        this.aService = aService;
    }
}
