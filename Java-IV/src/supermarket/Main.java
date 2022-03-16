package supermarket;

import supermarket.utils.Util;
import supermarket.views.MainService;

public class Main extends Util {
    public static void main(String[] args) {
        MainService mainService = MainService.getInstance();
        mainService.execute();
    }
}
