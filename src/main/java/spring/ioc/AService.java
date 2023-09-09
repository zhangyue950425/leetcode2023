package spring.ioc;

public class AService {

    private BService bService;
    public AService() { }
    public AService(BService bService) {
        this.bService = bService;
    }
    public BService getbService() {
        return bService;
    }
    public void setbService(BService bService) {
        this.bService = bService;
    }
}
