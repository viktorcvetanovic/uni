<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Employees Detail</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Employees Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="EmployeeNumber:"/>
                    <h:outputText value="#{employees.employees.employeeNumber}" title="EmployeeNumber" />
                    <h:outputText value="LastName:"/>
                    <h:outputText value="#{employees.employees.lastName}" title="LastName" />
                    <h:outputText value="FirstName:"/>
                    <h:outputText value="#{employees.employees.firstName}" title="FirstName" />
                    <h:outputText value="Extension:"/>
                    <h:outputText value="#{employees.employees.extension}" title="Extension" />
                    <h:outputText value="Email:"/>
                    <h:outputText value="#{employees.employees.email}" title="Email" />
                    <h:outputText value="OfficeCode:"/>
                    <h:outputText value="#{employees.employees.officeCode}" title="OfficeCode" />
                    <h:outputText value="ReportsTo:"/>
                    <h:outputText value="#{employees.employees.reportsTo}" title="ReportsTo" />
                    <h:outputText value="JobTitle:"/>
                    <h:outputText value="#{employees.employees.jobTitle}" title="JobTitle" />
                    <h:outputText value="CustomerNumber:"/>
                    <h:panelGroup>
                        <h:outputText value="#{employees.employees.customerNumber}"/>
                        <h:panelGroup rendered="#{employees.employees.customerNumber != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{customers.detailSetup}">
                                <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees][employees.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees.customerNumber][customers.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="employees"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.EmployeesController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{customers.editSetup}">
                                <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees][employees.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees.customerNumber][customers.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="employees"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.EmployeesController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{customers.destroy}">
                                <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees][employees.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees.customerNumber][customers.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="employees"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.EmployeesController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="ParentEmployee:"/>
                    <h:panelGroup>
                        <h:outputText value="#{employees.employees.parentEmployee}"/>
                        <h:panelGroup rendered="#{employees.employees.parentEmployee != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{employees.detailSetup}">
                                <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees][employees.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees.parentEmployee][employees.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="employees"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.EmployeesController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{employees.editSetup}">
                                <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees][employees.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees.parentEmployee][employees.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="employees"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.EmployeesController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{employees.destroy}">
                                <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees][employees.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees.parentEmployee][employees.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="employees"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.EmployeesController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>

                    <h:outputText value="EmployeesList:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty employees.employees.employeesList}" value="(No Items)"/>
                        <h:dataTable value="#{employees.employees.employeesList}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty employees.employees.employeesList}">
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
                                    <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees][employees.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][employees.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="employees" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.EmployeesController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{employees.editSetup}">
                                    <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees][employees.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][employees.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="employees" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.EmployeesController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{employees.destroy}">
                                    <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees][employees.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][employees.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="employees" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.EmployeesController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{employees.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees][employees.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{employees.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][employees.employees][employees.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{employees.createSetup}" value="New Employees" />
                <br />
                <h:commandLink action="#{employees.listSetup}" value="Show All Employees Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
