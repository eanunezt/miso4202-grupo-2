package marketplace.enums;

/**
 *  @generated
 *  @author eanunezt
 */
public enum  RolEnum  {
ADMINISTRADOR("ADMINISTRADOR")
,CLIENTE("CLIENTE")
,PROVEEDOR("PROVEEDOR")
;//, OTRO(),....;
  private final String name; // internal
  private final int id; // internal
   RolEnum(String name,int id) {   
       this.name = name;
       this.id = id;
}
	RolEnum(String name) {   
       this.name = name;
       this.id = -1;
}

	public String getName() {
		return this.name;
	}
	public int getId() {
		return this.id;
	}
}

