<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'table.label', default: 'Table')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-table" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                            default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-table" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <fieldset class="form">
        <li class="fieldcontain">
            <span id="name-label" class="name-label">Name</span>
            <g:field type="name" name="name" disabled="true" value="${table?.name}"/>
        </li>
        <li class="fieldcontain">
            <span id="waiter-name-label" class="name-label">Waiter Name</span>
            <g:field type="name" name="waiter-name" disabled="true" value="${table?.waiter?.username}"/>

        </li>
        <g:if test="${table?.isFree()}">
            <g:link resource="order" params="[table: table?.id]" action="create">New Order</g:link>
        </g:if>
        <g:else>
            <g:link resource="order" id="${table.getActiveOrder()?.id}" params="[table: table?.id]"
                    action="show">See active order</g:link>
        </g:else>

    </fieldset>            <g:form resource="${this.table}" method="DELETE">
    <fieldset class="buttons">
        <g:link class="edit" action="edit" resource="${this.table}"><g:message code="default.button.edit.label"
                                                                               default="Edit"/></g:link>
        <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}"
               onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
    </fieldset>
</g:form>
</div>
</body>
</html>
