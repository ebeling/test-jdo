/*
 * Created on 11.08.2005
 *
 * Copyright by G.punkt
 */
package mydomain.model;

import java.util.ArrayList;
import java.util.Iterator;

public class FieldContainer {
  
    private String id;
    private ArrayList<Field> fields;
    
    public FieldContainer() {
        super();
    }
       
    public FieldContainer(String id) {
        super();
        this.id = id;
    }

    /**
     * @return Returns the fields.
     */
    public ArrayList<Field> getFields() {
        return fields;
    }
    /**
     * @param fields The fields to set.
     */
    public void setFields(ArrayList<Field> fields) {
        this.fields = fields;
    }
    /**
     * @return Returns the id.
     */
    public String getId() {
        return id;
    }
    /**
     * @param id The id to set.
     */
    public void setId(String id) {
        this.id = id;
    }
    
    public Field getFieldWithId(int id){
        if (getFields()==null) return null;
        Iterator<Field> iter = getFields().iterator();
        while (iter.hasNext()){
            Field field = (Field)iter.next();
            if (field.getId()==id) return field;
        }
        return null;
    }
    
    public Field getFieldByResourceKey(String key){
        if (getFields()==null) return null;
        Iterator<Field> iter = getFields().iterator();
        while (iter.hasNext()){
            Field field = (Field)iter.next();
            if (field.getResourceKey() != null && field.getResourceKey().equals(key)) return field;
        }
        return null;
    }
    
    public void setField(Field field){
        if (field==null) return;
        if (getFields()==null){
            fields = new ArrayList<Field>();
            fields.add(field);
            return;
        }

        for (int i=0; i<fields.size(); i++){
            if (((Field)fields.get(i)).getId()==field.getId()){
                ((Field)fields.get(i)).setResourceKey(field.getResourceKey());
                return;
            }
        }
        
        fields.add(field);
    }

    public static Field getFieldFromList(int id, ArrayList<Field> fieldList){
        if ((fieldList==null)||(fieldList.size()<1)) return null;
        Iterator<Field> iter = fieldList.iterator();
        while (iter.hasNext()){
            Field field = (Field)iter.next();
            if (field.getId()==id) return field;
        }
        return null;
    }
    
    public static ArrayList<Field> mergeFieldLists(ArrayList<Field> lField1, ArrayList<Field> lField2){
		if((lField1==null)&&(lField2==null)) return null;
		ArrayList<Field> lmerged = new ArrayList<Field>();
		Iterator<Field> iterL2 = lField2.iterator();
		while(iterL2.hasNext()){
			Field fieldFrom2 = iterL2.next();
			Field fieldequvalentFrom1 = getFieldFromList(fieldFrom2.getId(), lField1);
			if(fieldequvalentFrom1!=null){
				lmerged.add(fieldequvalentFrom1);
			}else{
				lmerged.add(fieldFrom2);
			}
		}
		return lmerged;
	}
}
