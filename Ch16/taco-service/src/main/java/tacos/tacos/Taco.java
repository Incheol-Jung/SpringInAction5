package tacos.tacos;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@Document
@RestResource(rel="tacos", path="tacos")
public class Taco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  
  private String name;
  
  private Date createdAt = new Date();

  private List<Ingredient> ingredients;

}
