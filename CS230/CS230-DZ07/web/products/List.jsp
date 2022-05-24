<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Products Items</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Products Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Products Items Found)<br />" rendered="#{products.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{products.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{products.pagingInfo.firstItem + 1}..#{products.pagingInfo.lastItem} of #{products.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{products.prev}" value="Previous #{products.pagingInfo.batchSize}" rendered="#{products.pagingInfo.firstItem >= products.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{products.next}" value="Next #{products.pagingInfo.batchSize}" rendered="#{products.pagingInfo.lastItem + products.pagingInfo.batchSize <= products.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{products.next}" value="Remaining #{products.pagingInfo.itemCount - products.pagingInfo.lastItem}"
                                   rendered="#{products.pagingInfo.lastItem < products.pagingInfo.itemCount && products.pagingInfo.lastItem + products.pagingInfo.batchSize > products.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{products.productsItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Code"/>
                            </f:facet>
                            <h:outputText value="#{item.code}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Name"/>
                            </f:facet>
                            <h:outputText value="#{item.name}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Line"/>
                            </f:facet>
                            <h:outputText value="#{item.line}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Scale"/>
                            </f:facet>
                            <h:outputText value="#{item.scale}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Vendor"/>
                            </f:facet>
                            <h:outputText value="#{item.vendor}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Description"/>
                            </f:facet>
                            <h:outputText value="#{item.description}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="QuantityInStock"/>
                            </f:facet>
                            <h:outputText value="#{item.quantityInStock}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="BuyPrice"/>
                            </f:facet>
                            <h:outputText value="#{item.buyPrice}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Msrp"/>
                            </f:facet>
                            <h:outputText value="#{item.msrp}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{products.detailSetup}">
                                <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][products.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{products.editSetup}">
                                <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][products.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{products.remove}">
                                <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][products.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{products.createSetup}" value="New Products"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
