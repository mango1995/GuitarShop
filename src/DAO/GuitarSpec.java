package DAO;
public class GuitarSpec {
 
  public Builder builder; 
  public String model;
  public Type type;
  public int numStrings;
  public Wood backWood;
  public Wood topWood;

  public GuitarSpec(Builder builder, String model, Type type,
                    int numStrings, Wood backWood, Wood topWood) {
    this.builder = builder;
    this.model = model;
    this.type = type;
    this.numStrings = numStrings;
    this.backWood = backWood;
    this.topWood = topWood;
  }

  public Builder getBuilder() {
    return builder;
  }

  public String getModel() {
    return model;
  }

  public Type getType() {
    return type;
  }

  public int getNumStrings() {
    return numStrings;
  }

  public Wood getBackWood() {
    return backWood;
  }

  public Wood getTopWood() {
    return topWood;
  }

  public boolean matches(GuitarSpec otherSpec, String search) {
		if(search.equals(otherSpec.builder.toString().toUpperCase())){
			return true;
		}else if(search.equals(otherSpec.backWood.toString().toUpperCase())){
			return true;
		}else if(search.equals(otherSpec.topWood.toString().toUpperCase())){
			return true;
		}else if(search.equals(otherSpec.type.toString().toUpperCase())){
			return true;
		}else{
			return false;
		}
	}
}
