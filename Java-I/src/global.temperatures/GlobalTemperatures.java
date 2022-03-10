package global.temperatures;

public class GlobalTemperatures {
    public static void main(String[] args) {
        String[] cities = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Assuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };
        int[][] temps = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };
        hottestCity(cities, temps);
        coldestCity(cities, temps);
    }


    public static void coldestCity(String[] cities, int[][] temps){
        int minTempCity = minTempCity(temps);

        String minTempCityName = cities[minTempCity];
        int minTempValue = temps[minTempCity][0];

        System.out.println("Cidade mais fria: " + minTempCityName);
        System.out.println("Menor temperatura: " + minTempValue);
    }


    public static void hottestCity(String[] cities, int[][] temps){
        int maxTempCity = maxTempCity(temps);

        String maxTempCityName = cities[maxTempCity];
        int maxTempValue = temps[maxTempCity][1];

        System.out.println("Cidade mais quente: " + maxTempCityName);
        System.out.println("Maior temperatura: " + maxTempValue);
    }


    public static int minTempCity(int[][] temps) {
        int minTempValue = Integer.MAX_VALUE;
        int minTempCity = 0;
        int cityMinTemp;

        for (int i=0; i<temps.length; i++) {
            cityMinTemp = temps[i][0];
            if (cityMinTemp < minTempValue){
                minTempValue = cityMinTemp;
                minTempCity = i;
            }
        }
        return minTempCity;
    }


    public static int maxTempCity(int[][] temps) {
        int maxTempValue = Integer.MIN_VALUE;
        int maxTempCity = 0;
        int cityMaxTemp;

        for (int i=0; i<temps.length; i++) {
            cityMaxTemp = temps[i][1];
            if (cityMaxTemp > maxTempValue){
                maxTempValue = cityMaxTemp;
                maxTempCity = i;
            }
        }

        return maxTempCity;
    }
}
