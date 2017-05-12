package com.rivetlogic.ecommerce.shoppingcart.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.rivetlogic.ecommerce.shoppingcart.configuration.ShoppingCartConfiguration")
public interface ShoppingCartConfiguration {

   @Meta.AD(required = false)
    public String storeEmail();
 
    @Meta.AD(required = false)
    public String storeName();
    
    @Meta.AD(required = false)
    public String storeEmailSubject();
 
    @Meta.AD(required = false)
    public String storeEmailContent();
    
    @Meta.AD(required = false)
    public String customerEmailSubject();
 
    @Meta.AD(required = false)
    public String customerEmailContent();
    
    @Meta.AD(required = false)
    public String checkoutSuccessMessage();
 
    @Meta.AD(required = false)
    public String checkoutErrorMessage();
    
    
    @Meta.AD(required = false)
    public String cartEmptyMessage();
 
    @Meta.AD(required = false)
    public String enablePaypal();
    
    @Meta.AD(required = false)
    public String paypalEmail();
 
    
    
    


}