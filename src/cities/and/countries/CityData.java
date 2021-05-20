/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cities.and.countries;

/**
 *
 * @author icg
 */
public class CityData {

    //CityData(String string, String string0, String string1, int parseInt, int parseInt0) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    
    //public class City {
         String code;
         String name;
         String contient;
         Integer surface_area;
         Integer population;
         Boolean capital;
    
    
        public CityData(String code, String name, String contient, Integer surface_area, Integer population, Boolean capital){
            this.code = code;
            this.name = name;
            this.contient = contient;
            this.surface_area = surface_area;
            this.population = population;
            this.capital = capital;
        }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

        public void setCity(String code) {
            this.code = code;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setContient(String contient) {
            this.contient = contient;
        }

        public void setSurface_area(Integer surface_area) {
            this.surface_area = surface_area;
        }

        public void setPopulation(Integer population) {
            this.population = population;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public String getContient() {
            return contient;
        }

        public Integer getSurface_area() {
            return surface_area;
        }

        public Integer getPopulation() {
            return population;
        }
         
    //}
}
