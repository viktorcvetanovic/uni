<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Offices Items</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Offices Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Offices Items Found)<br />" rendered="#{offices.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{offices.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{offices.pagingInfo.firstItem + 1}..#{offices.pagingInfo.lastItem} of #{offices.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{offices.prev}" value="Previous #{offices.pagingInfo.batchSize}" rendered="#{offices.pagingInfo.firstItem >= offices.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{offices.next}" value="Next #{offices.pagingInfo.batchSize}" rendered="#{offices.pagingInfo.lastItem + offices.pagingInfo.batchSize <= offices.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{offices.next}" value="Remaining #{offices.pagingInfo.itemCount - offices.pagingInfo.lastItem}"
                                   rendered="#{offices.pagingInfo.lastItem < offices.pagingInfo.itemCount && offices.pagingInfo.lastItem + offices.pagingInfo.batchSize > offices.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{offices.officesItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="OfficeCode"/>
                            </f:facet>
                            <h:outputText value="#{item.officeCode}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="City"/>
                            </f:facet>
                            <h:outputText value="#{item.city}"/>
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
                                <h:outputText value="State"/>
                            </f:facet>
                            <h:outputText value="#{item.state}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Country"/>
                            </f:facet>
                            <h:outputText value="#{item.country}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="PostalCode"/>
                            </f:facet>
                            <h:outputText value="#{item.postalCode}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Territory"/>
                            </f:facet>
                            <h:outputText value="#{item.territory}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{offices.detailSetup}">
                                <f:param name="jsfcrud.currentOffices" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][offices.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{offices.editSetup}">
                                <f:param name="jsfcrud.currentOffices" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][offices.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{offices.remove}">
                                <f:param name="jsfcrud.currentOffices" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][offices.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{offices.createSetup}" value="New Offices"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
