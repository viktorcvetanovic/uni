<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Customers Detail</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Customers Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="CustomerNumber:"/>
                    <h:outputText value="#{customers.customers.customerNumber}" title="CustomerNumber" />
                    <h:outputText value="Name:"/>
                    <h:outputText value="#{customers.customers.name}" title="Name" />
                    <h:outputText value="Contact:"/>
                    <h:outputText value="#{customers.customers.contact}" title="Contact" />
                    <h:outputText value="Phone:"/>
                    <h:outputText value="#{customers.customers.phone}" title="Phone" />
                    <h:outputText value="Address:"/>
                    <h:outputText value="#{customers.customers.address}" title="Address" />
                    <h:outputText value="City:"/>
                    <h:outputText value="#{customers.customers.city}" title="City" />
                    <h:outputText value="State:"/>
                    <h:outputText value="#{customers.customers.state}" title="State" />
                    <h:outputText value="PostalCode:"/>
                    <h:outputText value="#{customers.customers.postalCode}" title="PostalCode" />
                    <h:outputText value="Country:"/>
                    <h:outputText value="#{customers.customers.country}" title="Country" />
                    <h:outputText value="SalesRepEmployeeNumber:"/>
                    <h:outputText value="#{customers.customers.salesRepEmployeeNumber}" title="SalesRepEmployeeNumber" />
                    <h:outputText value="CreditLimit:"/>
                    <h:outputText value="#{customers.customers.creditLimit}" title="CreditLimit" />

                    <h:outputText value="PaymentsList:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty customers.customers.paymentsList}" value="(No Items)"/>
                        <h:dataTable value="#{customers.customers.paymentsList}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty customers.customers.paymentsList}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="PaymentDate"/>
                                </f:facet>
                                <h:outputText value="#{item.paymentDate}">
                                    <f:convertDateTime pattern="MM/dd/yyyy" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Amount"/>
                                </f:facet>
                                <h:outputText value="#{item.amount}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CheckNumber"/>
                                </f:facet>
                                <h:outputText value="#{item.checkNumber}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CustomerNumber"/>
                                </f:facet>
                                <h:outputText value="#{item.customerNumber}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{payments.detailSetup}">
                                    <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customers.customers][customers.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentPayments" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][payments.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customers" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.CustomersController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{payments.editSetup}">
                                    <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customers.customers][customers.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentPayments" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][payments.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customers" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.CustomersController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{payments.destroy}">
                                    <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customers.customers][customers.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentPayments" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][payments.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customers" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.CustomersController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>
                    <h:outputText value="EmployeesList:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty customers.customers.employeesList}" value="(No Items)"/>
                        <h:dataTable value="#{customers.customers.employeesList}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty customers.customers.employeesList}">
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
                                    <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customers.customers][customers.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][employees.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customers" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.CustomersController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{employees.editSetup}">
                                    <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customers.customers][customers.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][employees.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customers" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.CustomersController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{employees.destroy}">
                                    <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customers.customers][customers.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentEmployees" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][employees.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customers" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.CustomersController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{customers.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customers.customers][customers.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{customers.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentCustomers" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customers.customers][customers.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{customers.createSetup}" value="New Customers" />
                <br />
                <h:commandLink action="#{customers.listSetup}" value="Show All Customers Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
