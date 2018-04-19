package reporting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;


public class DeviceContext {
	private static final Logger LOG = Logger.getLogger(DeviceContext.class);
	private String deviceName = null;
	private String version = null;
	private String platform = null;
	private static Map<DeviceContext,DeviceContext> mapDeviceContext = new HashMap<DeviceContext,DeviceContext>();
	private static List<DeviceContext> listDeviceContext = new ArrayList<DeviceContext>();
	/**
	 * No Argument Constructor
	 */
	private DeviceContext()
	{
		
	}
	/**
	 * Consutructor With Arguments
	 * @param browserName
	 * @param version
	 * @param platform
	 */
	private DeviceContext(String deviceName, String platform , String version)
	{
		this.deviceName = deviceName;
		this.version = version;
		this.platform = platform;
		LOG.debug("DeviceContext Object Initialized With deviceName ( " + this.deviceName + " ) , deviceVersion  ( " + this.getDeviceVersion() + " , devicePlatform ( " + this.getDevicePlatform() + " )");
	}
	
	/**
	 * 
	 * @param deviceName
	 */
	public void setDeviceName(String deviceName)
	{
		this.deviceName = deviceName;
		LOG.debug("DeviceContext Object Set With deviceName ( " + this.deviceName + " ) ");
	}
	
	/**
	 * 
	 * @param version
	 */
	public void setVersion(String version)
	{
		this.version = version;
		LOG.debug("DeviceContext Object Set With deviceVersion ( " + this.version + " ) ");
	}
	
	/**
	 * 
	 * @param platform
	 */
	public void setPlatform(String platform)
	{
		this.platform = platform;
		LOG.debug("DeviceContext Object Set With devicePlatform ( " + this.platform + " ) ");
	}
	
	/**
	 * 
	 * @return deviceName
	 */
	public String getDeviceName()
	{
		LOG.debug("Being returned : " + this.deviceName);
		return this.deviceName ;
		
	}
	
	/**
	 * 
	 * @return version
	 */
	public String getDeviceVersion()
	{
		LOG.debug("Being returned : " + this.version);
		return this.version ;
	}
	
	/**
	 * 
	 * @return platform
	 */
	public String getDevicePlatform()
	{
		LOG.debug("Being returned : " + this.platform);
		return this.platform;
		
	}
	
	
	@Override
	public int hashCode()
	{
		int length = 0;
		
		/*
		 * get length of browserName
		 */
		length = this.getDeviceName() == null ? 0 : this.getDeviceName().length();
		LOG.debug("length of BrowserName = " + length);
		/**
		 * add length of device version to existing length
		 */
		length = length + (this.getDeviceVersion() == null ? 0 : this.getDeviceName().length());
		LOG.debug("length of DeviceName + version = " + length);
		
		/**
		 * add length of platform to existing length
		 */
		length = length + (this.getDevicePlatform() == null ? 0 : this.getDevicePlatform().length());
		
		LOG.debug("length of DeviceName + version + platform = " + length);
		return length;
		
	}
	
	@Override
	public boolean equals(Object o)
	{
		boolean isEquals = false;
		
		if(o instanceof DeviceContext)
		{
			/**
			 * get browserName from Object o
			 */
			String objOdeviceName = ((DeviceContext)o).getDeviceName();
			
			/**
			 * get version from Object o
			 */
			String objODeviceVer = ((DeviceContext)o).getDeviceVersion();
			
			String objOPlatform =  ((DeviceContext)o).getDevicePlatform();
			
			if(this.deviceName.equals(objOdeviceName) && this.version.equals(objODeviceVer) && this.platform.equals(objOPlatform))
			{
				isEquals = true;
			}
			
		}
		return isEquals;
	}
	
	@Override
	public String toString()
	{
		String deviceInfo = "<DeviceContext><Name> " + this.deviceName + "</Name><Version> " + this.version + "</Version><Platform>" + this.platform + "</Platform></DeviceContext>";
		LOG.info(deviceInfo);
		return deviceInfo;
	}
	/**
	 * synchronized static method which gets unique BrowserContext with respect to given
	 * browserName,version and platform
	 */
	public synchronized static DeviceContext getDeviceContext(String deviceName, String platform, String version)
	{
		DeviceContext deviceContext =  new DeviceContext(deviceName, platform, version);
		if(DeviceContext.mapDeviceContext.get(deviceContext) == null)
		{
			String logInfo = "New DeviceContext Instance Was Created And Placed In Map : DeviceContext.mapDeviceContext";
			LOG.info(logInfo);
		DeviceContext.mapDeviceContext.put(deviceContext, deviceContext);
			DeviceContext.listDeviceContext.add(deviceContext);
		}
		deviceContext = DeviceContext.mapDeviceContext.get(deviceContext);
		String logInfo = deviceContext.toString();
		LOG.info("DeviceContext Info Being returned: " + logInfo);
		return deviceContext;
	}
	
	public static List<DeviceContext> getDeviceContextList()
	{
		return DeviceContext.listDeviceContext;
	}
}
