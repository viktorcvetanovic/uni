<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Employees Items</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Employees Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Employees Items Found)<br />" rendered="#{employees.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{employees.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{employees.pagingInfo.firstItem + 1}..#{employees.pagingInfo.lastItem} of #{employees.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{employees.prev}" value="Previous #{employees.pagingInfo.batchSize}" rendered="#{employees.pagingInfo.firstItem >= employees.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{employees.next}" value="Next #{employees.pagingInfo.batchSize}" rendered="#{employees.pagingInfo.lastItem + employees.pagingInfo.batchSize <= employees.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{employees.next}" value="Remaining #{employees.pagingInfo.itemCount - employees.pagingInfo.lastItem}"
                                   rendered="#{employees.pagingInfo.lastItem < employees.pagingInfo.itemCount && employees.pagingInfo.lastItem + employees.pagingInfo.batchSize > employees.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{employees.employeesItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="EmployeeNumber"/>
                            </f:facet>
                            <h:outputText value="#{item.employeeNumber}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="LastName"/>
                            </f:facet>
                            <h:outputText value="#{item.lastName}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="FirstName"/>
                            </f:facet>
                            <h:outputText value="#{item.firstName}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Extension"/>
                            </f:facet>
                            <h:outputText value="#{item.extension}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Email"/>
                            </f:facet>
                            <h:outputText value="#{item.email}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="OfficeCode"/>
                            </f:facet>
                            <h:outputText value="#{item.officeCode}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="ReportsTo"/>
                            </f:facet>
                            <h:outputText value="#{item.reportsTo}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="JobTitle"/>
                            </f:facet>
                            <h:outputText value="#{item.jobTitle}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="CustomerNumber"/>
                            </f:facet>
                            <h:outputText value="#{item.customerNumber}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="ParentEmployee"/>
                            </f:facet>
                            <h:outputText value="#{item.parentEmployee}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{employees.detailSetup}">
                                <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][employees.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{employees.editSetup}">
                                <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][employees.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{employees.remove}">
                                <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][employees.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{employees.createSetup}" value="New Employees"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
