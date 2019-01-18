package esparaquia.Json2java.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class App {
    //Main class

    public static void main(String [] args){

        try {
            ObjectMapper myMapper = new ObjectMapper();
            //Get the file from a directory:
            InputStream inputStream = new FileInputStream(new File("/My/to/the/file.json"));

            //Indicate the type of data, that indicates is a list of person objects
            TypeReference<List<Person>> typeReference = new TypeReference<List<Person>>() {};
            //Read the JSON file and obtain the list of Person Objects by using mapper.readValue
            List<Person> persons = myMapper.readValue(inputStream, typeReference);
            // At this line we already get the data from the file, now is time to check it:
            for (Person p : persons){

                System.out.println("Name is: "+p.getFirstName()+" city is: "+p.getAddress().getCity()+" First car is: "+p.getCars()[0]);
            }

            // Save this into a document by calling first the Person object and the setters:
            Person person = new Person();
            person.setFirstName("Ryan");
            person.setLastName("McGonnegy");
            person.setAge(23);
            person.setAddress(new Address("456 St","Timberland","60033"));
            person.setCars(new String[]{"Ford Mustang", "Honda Accord", "Volkswagen GLI"});
            //Specify where wyou want to save it and the name of the file and the object we want to write, in this case is person
            myMapper.writeValue(new File("/My/to/the/outputfile.json"), person);
            //Close inputStream
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
