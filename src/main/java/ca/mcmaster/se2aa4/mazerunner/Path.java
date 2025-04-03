package ca.mcmaster.se2aa4.mazerunner;

public class Path  {
    String pathway; //path represented using
    public static Path instance; //singleton instance
   
    private Path(){
      this.pathway = "";

    }

    public static Path getInstance(){ //get instance of path
        if(instance == null){ //if instance is not initialized
            instance = new Path(); //initialize instance
        }
        return instance; //return instance
    }

    // public Path(){  // overloadng to allow no initial path
    //   this.pathway = "";
    // }

    public void add(String str){ //add to path
        this.pathway += str;
    }

    public void CanonicalToFactorized(){ //turn Canonical path to Factorized
        String sections[] = this.pathway.split(" "); //split into array from all spaces
        String factorizedpath = ""; 
        for (String section : sections){
            Integer count = section.length();
            if (count == 1){ //if the length of the section is only 1 no number needed
                factorizedpath+=section;
            }else{ //if not include the count of the dimension and the dimension
                factorizedpath+= count.toString();
                factorizedpath+= String.valueOf(section.charAt(0));
            }
            factorizedpath += " ";
        }
        this.pathway = factorizedpath.trim();
    }

    public void factorizedtoCanonical(){ //turn factorized to canonical
        String sections[] = this.pathway.split(" "); //split into array from all spaces
        String canonical = "";
        for (String section : sections){
            boolean hasDigit = section.substring(0, 1).matches("\\d"); 
            String dir = section.substring(section.length()-1,section.length()); //get the letter representing direction
            if (hasDigit){ //if there is a digit in the section
            
                String number = section.substring(0,section.length()-1); //get the number
                for(int i = 0; i< Integer.parseInt(number); i++){ //add the letter, number times
                    canonical += dir;
                }
            }else{
                canonical += dir;
            }
            canonical += " ";
        }
        this.pathway = canonical;

    }
    @Override
    public String toString() { //override toString method
        return pathway;
    }

    public void setPath(String path){ //set path
        this.pathway = path;
    }



    public void MoveRight(){
        this.add(" "); //add instructions in canonical form
        this.add("R");
        this.add(" ");
        this.add("F");
    }

    public void MoveLeft(){
        this.add(" "); //add instructions in canonical form
        this.add("L");
        this.add(" ");
        this.add("F");
    }
    public void MoveForward(){
        System.out.println("in player path");
        this.add("F"); //add instructions in canonical form
    }
    public void MoveBackward(){
        this.add(" "); //add instructions in canonical form
        this.add("B");
        this.add(" ");
        this.add("F"); //add instructions in canonical form
    }


}
