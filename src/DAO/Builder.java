package DAO;
public enum Builder { 

	FENDER,OLSON, PRS, ANY;

  public String toString() {
    switch(this) {
      case FENDER:   return "Fender";
      case OLSON:    return "Olson";
      case PRS :     return "PRS";
      default:       return "Unspecified";
    }
  }
}

		

	