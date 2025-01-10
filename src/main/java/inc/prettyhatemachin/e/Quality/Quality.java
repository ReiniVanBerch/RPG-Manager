package inc.prettyhatemachin.e.Quality;


import inc.prettyhatemachin.e.Exception.InvalidTypeException;
import inc.prettyhatemachin.e.Tools.TypeHelper;

import java.util.ArrayList;

public class Quality {

    private Class<? extends Quality> quality;
    private Class<?> datatype;
    private String comment;
    private ArrayList<?> values;

    TypeHelper typeHelper;


    public Quality(String comment, int typeNumber, ArrayList<?> values) {

        try{

            this.comment = comment;
            this.values = values;

            if(typeNumber < 0xFF) {
                TypeHelper typeHelper = new TypeHelper();

                this.quality = typeHelper.getQuality(typeNumber);
                this.datatype = typeHelper.getDataType(typeNumber);
            }
            else throw new InvalidTypeException("");
        } catch (InvalidTypeException e){

            //
            //INVALID INPUT FOR
            //


        }

    }

    public int getTypeNumber() {
        int qi = TypeHelper.getQualityInt(this.quality);
        int ti = TypeHelper.getTypeInt(this.datatype);
        return qi + ti;
    }

    public void setComment(String comment){this.comment = comment;}
    public String getComment(){return this.comment;}

    public Class<?> getDataType(){
        return this.datatype;
    }


}
