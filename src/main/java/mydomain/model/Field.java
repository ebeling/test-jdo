/*
 * Created on 30.08.2005
 *
 * Copyright by G.punkt
 */
package mydomain.model;

public class Field {  
    int id = -1;   
    String resourceKey;   
    boolean deleted = false;
    
    
    public Field() {
        super();
    }

    public Field(int id, String key) {
        super();
        this.id = id;
        resourceKey = key;
    }


    
    /**	
	 * @param id
	 * @param resourceKey
	 * @param deleted
	 */
	public Field(int id, String resourceKey, boolean deleted) {
		super();		
		this.id = id;
		this.resourceKey = resourceKey;
		this.deleted = deleted;
	}

	/**
     * @return Returns the id.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id The id to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Returns the resourceKey.
     */
    public String getResourceKey() {
        return resourceKey;
    }

    /**
     * @param resourceKey The resourceKey to set.
     */
    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {		
		boolean res = super.equals(obj);
		if(obj instanceof Field){
			res = this.id == ((Field) obj).getId();
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.id;
	}

}
