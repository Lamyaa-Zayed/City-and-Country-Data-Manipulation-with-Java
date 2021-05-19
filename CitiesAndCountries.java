/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cities.and.countries;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Comp implements Comparator<CityData>
{

    @Override
    public int compare(CityData t, CityData t1) {
        return t.getPopulation().compareTo(t1.getPopulation());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
/**
 *
 * @author icg
 */
public class CitiesAndCountries {

    /**
     * @param args the command line arguments
     */
    
    public static List<CityData> sort(List<CityData> CityList)
    {
        CityList.sort(new Comp());
        return CityList;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int i;
        
        File CityFile = new File("city.csv");
        File CountryFile = new File("country.csv");
        
        List<String> CityLines = new ArrayList<>();
        List<String> CountryLines = new ArrayList<>();
        
        List<CityData> CityList = new ArrayList<>();
        List<CountryData> CountryList = new ArrayList<>();
        
        Map<String,List<CityData>> map = new HashMap<>();
        
        try
        {
           CityLines = Files.readAllLines(CityFile.toPath());
           //System.out.println("city" + CityLines.size());
           CountryLines = Files.readAllLines(CountryFile.toPath());
           //System.out.println("country" + CountryLines.size());
        }
        catch(IOException e)
        {
            System.out.println("error ReadingCSV Files");
        }
        
        for( i=0;i<CityLines.size();i++)
        {
            String Lines = CityLines.get(i);
            String[] SplittedData = Lines.split(",");
            //System.out.println(SplittedData[0]);
            //System.out.println(SplittedData[1]);
            CityData citySamples = new CityData(SplittedData[0],SplittedData[1],SplittedData[2],Integer.parseInt(SplittedData[3]),Integer.parseInt(SplittedData[4]),Boolean.parseBoolean(SplittedData[5]));
            CityList.add( citySamples);
        }
        
        for( i=0;i<CountryLines.size();i++)
        {
            String Lines = CountryLines.get(i);
            String[] SplittedData = Lines.split(",");
            //System.out.println(SplittedData[0]);
            //System.out.println(SplittedData[1]);
            CountryData countrySamples = new CountryData(SplittedData[0],SplittedData[1]);
            CountryList.add(countrySamples);
        }
        //System.out.println(CityList.size());
        //System.out.println(CountryList.size());
        
        for( i=0;i<CountryList.size();i++)
        {
          map.put(CountryList.get(i).getCode(), new ArrayList<>());
        }
        for( i=0;i<CityList.size();i++)
        {
            //System.out.println(CityList.get(i).code);
            List<CityData> List = map.get(CityList.get(i).code);
            List.add(CityList.get(i));
            map.put(CityList.get(i).code, List);
        }
        
        for( i=0;i<map.get("12650").size();i++)
        {
            System.out.println(map.get("12650").get(i).getName());
        }
        
        sort(map.get("12650"));  //key for ireland
        
        System.out.println("List after Sorting:");
        
        for( i=0;i<map.get("12650").size();i++)
        {
            System.out.println(map.get("12650").get(i).getName());
        }
        
        Integer maxPop = CityList.stream().mapToInt(CityData::getPopulation).max().getAsInt();
        System.out.println("MaxPopulation:"+maxPop);
        
        Integer maxPopContient = CityList.stream().filter(d->d.getContient().contains("europe")).mapToInt(CityData::getPopulation).max().getAsInt();
        System.out.println("MaxPopulationcontienet of Europe:"+maxPopContient);
        
        Integer maxPopContient2 = CityList.stream().filter(d->d.getContient().contains("africa")).mapToInt(CityData::getPopulation).max().getAsInt();
        System.out.println("MaxPopulationcontienet of Africa:"+maxPopContient2);
        
        Integer maxPopContient3 = CityList.stream().filter(d->d.getContient().contains("america")).mapToInt(CityData::getPopulation).max().getAsInt();
        System.out.println("MaxPopulationcontienet of America:"+maxPopContient3);
        
        //CityList.stream().forEach(d->System.out.println((d.getCapital())+"="+(d.getPopulation())));
        
        Integer maxPopCapital = CityList.stream().filter(d->d.getCapital()==true).mapToInt(CityData::getPopulation).max().getAsInt();
        System.out.println("MaxPopulationcapital:"+maxPopCapital);
        
        
        //CityList.stream().forEach(d->System.out.println((d.getContient())+"="+(d.getPopulation())));
        
        
        //CityList.stream().filter(d->d.getContient().contentEquals(cs)).forEach(d->System.out.println((d.getContient())+"="+(d.getPopulation())));
        //System.out.println("MaxPopulationcontienet:"+maxPopContient2);
        
        //System.out.println(FinalList);
        //citycountryDAO pDAO = new citycountryDAO();
        //List<CityData> x = pDAO.readcityFromCSV("city.csv");
        //System.out.println(x.get(2).getName());
    }
    
}
