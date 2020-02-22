package com.bicgraphic.ods.odsproductmarketingdata.common;

import com.bicgraphic.odsutils.ODSConstants;

public class ProductMarketingConstants extends ODSConstants{
	  
		// Product properties 

		public static final String PRODUCT_COLLECTION = "ProductsCollection";
		public static final String PRODUCT_DATABASE = "ProductsDB";
		public static final String PRODUCT_STATUS = "Inactive";
		public static final String PRODUCT_SOURCE_SYSTEMS = "GrandNode,Website,GN,EBS";
		public static final String PRODUCT_UPDATE_SOURCE_SYSTEMS = "GrandNode,Website,GN";
		   public static final String GN_SOURCE_SYSTEM = "GN";
		    public static final String EBS_SOURCE_SYSTEM = "EBS";
		public static final String EVENT_OBJECTS = "PRODUCT,ENTERPRISEPRODUCT,PRODUCTORG,PRODUCTALERT,PRODUCTATTRIBUTE";
		public static final String EVENT_OBJECT_PRODUCT="ENTERPRISEPRODUCT";
	
		
		// Response Messages
		public static final String ALREADYEXITS_MSG = "Product Already Exits";
		public static final String DATA_NOT_FOUND_MSG = "No Records found for given Product ID";
		public static final String PRODUCT_DOESNOTEXITS_MSG = "Product Does not Exists";
		public static final String EVENT_OBJECT_ERR_MSG = "EventObject value Should be ENTERPRISEPRODUCT/PRODUCTORG/PRODUCTALERT/PRODUCTATTRIBUTE";
		public static final String PRODUCT_EVENTBUSINESSID_PRODUCTID_ERR_MSG = "Product EventBusinessID should match  with Product's ProductId";
		public static final String EVENTBUSINESSID_PRODUCTID_ERR_MSG="EventBusinessID should match  with ProductId of ";
		public static final String EVENT_OBJECT_PRODUCT_ERR_MSG="EventObject value Should be PRODUCT";

		public static final String PRODUCT_ORG_NOT_FOUND_MSG = "No Data found in Product Organization for given productID";
		public static final String PRODUCT_NON_EBS_EVENTTYPE="When EventSourceSystem is GN EventType must not be CREATE";
		public static final String PRODUCT_SOURCE_SYSTEM_ERR_MSG="EventSourceSystem should GN/EBS";
		
		public static final String PRODUCT_ID_MANDATORTY="ProductId should not be null or empty";


		public static final String BIC_RESOURCE_ASSIGNMENT = "BIC RESOURCE ASSIGNMENT";
		public static final String PRODUCTORG_EBS_FIELDS = "categoryCode,categoryName,categoryStatus,categoryEffDate,Subcategorycode,"
				+ "SubcategoryName,Subcategorystatus,SubcategoryEffDate";

		public static final String PRODUCTORG_GN_FIELDS ="productLine,productName,description,AdditionalProductArray,categoryCode,categoryName,categoryStatus,"
				+ "categoryEffDate,Subcategorycode,SubcategoryName,Subcategorystatus,SubcategoryEffDate";
		
		
		public static final String PRODUCT_EBS_FIELDS = "productId,productName,productNameCanada,cannotShipto,productDescription,productCategory,"
				+ "productSubCategory,isHazardous,eBSCreateDate,oldProductId,eBSstatus,brand,odsLastModifiedDate";

		public static final String PRODUCT_GN_FIELDS = "productId,productSubstatus,subStatusReason,visibleFlag,activeDate,introDate,oldProductId,blanksAllowed,"
				+ "copyChangeAllowed,inkChangeAllowed,halftoneAllowed,pmsMatch,qualifiesForEQP,qualifiesForDSP,combinedQuantity,material,sampleFlag,"
				+ "webOrderableFlag,status,standardImprintColors,virtualSample,odsLastModifiedDate,gnStatus";
		
		public static final String PRODUCT_WS_NOT_REQUIRED_FIELDS = "productCategory,productSubCategory,ebsStatus,productDescription,productNameCanada,"
				+ "cannotShipto,introDate,ebsCreateDate,ebsIntroDate,brand,odsLastModifiedDate";
		
		public static final String REQ_BUILD_FAIL_CODE="INTERR-122";
		public static final String REQ_BUILD_FAIL_MSG="Unable to build Request Structure";
		
		// ODS constants... need to move them back.
		public static final String DATA_CONVERTION_FAIL_CODE="INTERR-122";
		public static final String DATA_CONVERTION_FAIL_MSG="Unable to convert Data , may be data contains missmatches";
		public static final String EVENT_NETWORK_ERR_CODE = "EVENT-ERR";
		public static final String EVENT_NETWORK_ERR_MSG = "Event insertion failed";
		public static final String ERROR_STATUS = "ERROR";
	    public static final String SUCCESS_STATUS = "SUCCESS";
	    public static final String SUCCESS_CODE = "INTERR-000";
	    public static final String FAIL_CODE = "INTERR-001";
	    public static final String SUCCESS_MSG = " Operation Successfully Completed";
	    public static final String FAIL_MSG = "  Operation Fail!";
	    public static final String INV_INPUT_CODE = "INTERR-113";
		public static final String PRODUCTMANAGER_TO_PRODUCTMARKETING = "PRODUCTMANAGER-TO-PRODUCTMARKETING";
		public static final String PRODUCT_ENTERPRISE_FIELDS="productId,eBSCreateDate,productName,productDescription,eBSstatus,brand";
	    
}

