<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Products Detail</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Products Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Code:"/>
                    <h:outputText value="#{products.products.code}" title="Code" />
                    <h:outputText value="Name:"/>
                    <h:outputText value="#{products.products.name}" title="Name" />
                    <h:outputText value="Line:"/>
                    <h:outputText value="#{products.products.line}" title="Line" />
                    <h:outputText value="Scale:"/>
                    <h:outputText value="#{products.products.scale}" title="Scale" />
                    <h:outputText value="Vendor:"/>
                    <h:outputText value="#{products.products.vendor}" title="Vendor" />
                    <h:outputText value="Description:"/>
                    <h:outputText value="#{products.products.description}" title="Description" />
                    <h:outputText value="QuantityInStock:"/>
                    <h:outputText value="#{products.products.quantityInStock}" title="QuantityInStock" />
                    <h:outputText value="BuyPrice:"/>
                    <h:outputText value="#{products.products.buyPrice}" title="BuyPrice" />
                    <h:outputText value="Msrp:"/>
                    <h:outputText value="#{products.products.msrp}" title="Msrp" />

                    <h:outputText value="ProductilnesList:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty products.products.productilnesList}" value="(No Items)"/>
                        <h:dataTable value="#{products.products.productilnesList}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty products.products.productilnesList}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ProductLine"/>
                                </f:facet>
                                <h:outputText value="#{item.productLine}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TextDescription"/>
                                </f:facet>
                                <h:outputText value="#{item.textDescription}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="HtmlDescription"/>
                                </f:facet>
                                <h:outputText value="#{item.htmlDescription}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Image"/>
                                </f:facet>
                                <h:outputText value="#{item.image}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Code"/>
                                </f:facet>
                                <h:outputText value="#{item.code}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{productilnes.detailSetup}">
                                    <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][products.products][products.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentProductilnes" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][productilnes.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="products" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.ProductsController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{productilnes.editSetup}">
                                    <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][products.products][products.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentProductilnes" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][productilnes.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="products" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.ProductsController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{productilnes.destroy}">
                                    <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][products.products][products.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentProductilnes" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][productilnes.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="products" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.ProductsController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>
                    <h:outputText value="OrderDetailsList:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty products.products.orderDetailsList}" value="(No Items)"/>
                        <h:dataTable value="#{products.products.orderDetailsList}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty products.products.orderDetailsList}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="QuantityOrdered"/>
                                </f:facet>
                                <h:outputText value="#{item.quantityOrdered}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="PriceEach"/>
                                </f:facet>
                                <h:outputText value="#{item.priceEach}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="OrderLineNumber"/>
                                </f:facet>
                                <h:outputText value="#{item.orderLineNumber}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="DetailsId"/>
                                </f:facet>
                                <h:outputText value="#{item.detailsId}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="OrderNumber"/>
                                </f:facet>
                                <h:outputText value="#{item.orderNumber}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Code"/>
                                </f:facet>
                                <h:outputText value="#{item.code}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{orderDetails.detailSetup}">
                                    <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][products.products][products.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][orderDetails.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="products" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.ProductsController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{orderDetails.editSetup}">
                                    <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][products.products][products.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][orderDetails.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="products" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.ProductsController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{orderDetails.destroy}">
                                    <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][products.products][products.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][orderDetails.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="products" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.ProductsController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{products.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][products.products][products.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{products.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][products.products][products.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{products.createSetup}" value="New Products" />
                <br />
                <h:commandLink action="#{products.listSetup}" value="Show All Products Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
