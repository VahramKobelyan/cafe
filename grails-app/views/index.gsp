<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>

<body>
<content tag="nav">

    <g:link controller='logout'>Logout <span class="caret"></span></g:link>

</content>

<div class="svg" role="presentation">
    <div class="grails-logo-container">
        <asset:image src="grails-cupsonly-logo-white.svg" class="grails-logo"/>
    </div>
</div>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Simple Cafe Manager Assignment</h1>

        <p>hi <cf:currentUserProps username="true"></cf:currentUserProps></p>
        <sec:ifAnyGranted roles="ROLE_MANAGER">
            <li><g:link class="list" controller="user" action="index"><g:message code="default.list.label"
                                                                                 args="['User']"/></g:link></li>
            <li><g:link class="list" controller="product" action="index"><g:message code="default.list.label"
                                                                                    args="['Porduct']"/></g:link></li>
        </sec:ifAnyGranted>
        <sec:ifAnyGranted roles="ROLE_WAITER">
        </sec:ifAnyGranted>
        <li><g:link class="list" controller="table" action="index"><g:message code="default.list.label"
                                                                              args="['Table']"/></g:link></li>
    </section>
</div>

</body>
</html>
