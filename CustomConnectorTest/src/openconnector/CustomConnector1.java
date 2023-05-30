package openconnector;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class CustomConnector1 extends AbstractConnector {
	
	private Log logger = LogFactory.getLog("connector.CustomConnector");
	
	 ////////////////////////////////////////////////////////////////////////////
    //
    // CONSTANTS
    //
    ////////////////////////////////////////////////////////////////////////////

    public static final String ATTR_USERNAME = "username";
    public static final String ATTR_FIRSTNAME = "firstname";
    public static final String ATTR_LASTNAME = "lastname";
    public static final String ATTR_EMAIL = "email";
    public static final String ATTR_GROUPS = "groups";

    public static final String ATTR_DISABLED = "disabled";
    public static final String ATTR_LOCKED = "locked";
    public static final String ATTR_PASSWORD = "password";
    public static final String ATTR_PASSWORD_OPTIONS = "passwordOptions";
    public static final String ATTR_PASSWORD_HISTORY = "passwordHistory";
    
    public static final String GROUP_ATTR_NAME = "name";
    public static final String GROUP_ATTR_DESCRIPTION = "description";

	
	
	
	
	@Override
	public Iterator<Map<String, Object>> iterate(Filter arg0) throws ConnectorException, UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> read(String arg0)
			throws ConnectorException, ObjectNotFoundException, UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	 /**
     * Connection always works.
     */
    public void testConnection() {

	String input1 = config.getString("input1");
	String input2 = config.getString("input2");
	System.out.println("Testing connector:\ninput1 = " + input1 + "\ninput2 = " + input2); 

    }
	
	/* (non-Javadoc)
     * @see openconnector.Connector#discoverSchema()
     */
    public Schema discoverSchema() {
        Schema schema = new Schema();
        
        if (OBJECT_TYPE_ACCOUNT.equals(this.objectType)) {
            schema.addAttribute(ATTR_USERNAME);
            schema.addAttribute(ATTR_FIRSTNAME);
            schema.addAttribute(ATTR_LASTNAME);
            schema.addAttribute(ATTR_EMAIL);
            schema.addAttribute(ATTR_GROUPS, Schema.Type.STRING, true);
            schema.addAttribute(ATTR_DISABLED, Schema.Type.BOOLEAN);
            schema.addAttribute(ATTR_LOCKED, Schema.Type.BOOLEAN);
            schema.addAttribute(ATTR_PASSWORD, Schema.Type.SECRET);
        }
        else {
            schema.addAttribute(GROUP_ATTR_NAME);
            schema.addAttribute(GROUP_ATTR_DESCRIPTION);
        }

        return schema;
    }
	
	
	
	
	
	
	
}
