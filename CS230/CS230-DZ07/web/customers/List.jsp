<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Customers Items</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Customers Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Customers Items Found)<br />" rendered="#{customers.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{customers.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{customers.pagingInfo.firstItem + 1}..#{customers.pagingInfo.lastItem} of #{customers.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{customers.prev}" value="Previous #{customers.pagingInfo.batchSize}" rendered="#{customers.pagingInfo.firstItem >= customers.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{customers.next}" value="Next #{customers.pagingInfo.batchSize}" rendered="#{customers.pagingInfo.lastItem + customers.pagingInfo.batchSize <= customers.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{customers.next}" value="Remaining #{customers.pagingInfo.itemCount - customers.pagingInfo.lastItem}"
                                   rendered="#{customers.pagingInfo.lastItem < customers.pagingInfo.itemCount && customers.pagingInfo.lastItem + customers.pagingInfo.batchSize > customers.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{customers.customersItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="CustomerNumber"/>
                            </f:facet>
                            <h:outputText value="#{item.customerNumber}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Name"/>
                            </f:facet>
                            <h:outputText value="#{item.name}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Contact"/>
                            </f:facet>
                            <h:outputText value="#{item.contact}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Phone"/>
                            </f:facet>
                            <h:outputText value="#{item.phone}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Address"/>
                            </f:facet>
                            <h:outputText value="#{item.address}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="City"/>
                            </f:facet>
                            <h:outputText value="#{item.city}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="State"/>
                            </f:facet>
                            <h:outputText value="#{item.state}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="PostalCode"/>
                            </f:facet>
                            <h:outputText value="#{item.postalCode}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Country"/>
                            </f:facet>
                            <h:outputText value="#{item.country}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="SalesRepEmployeeNumber"/>
                            </f:facet>
                            <h:outputText value="#{item.salesRepEmployeeNumber}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="CreditLimit"/>
                            </f:facet>
                            <h:outputText value="#{item.creditLimit}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{customers.detailSetup}">
                                <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][customers.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{customers.editSetup}">
                                <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][customers.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{customers.remove}">
                                <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][customers.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{customers.createSetup}" value="New Customers"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
