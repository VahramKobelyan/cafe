<fieldset class="form">
    <li class="fieldcontain">
        <span id="username-label" class="username-label">Username</span>
        <g:field type="text" name="username" value="${user?.username}"/>
    </li>
    <li class="fieldcontain">
        <span id="password-label" class="password-label">Password</span>
        <g:field type="password" name="new password" value=""/>
    </li>
    <li class="fieldcontain">
        <span id="role-label" class="role-label">UserRole</span>

        <g:select name="role"
                  from="${cafe.UserRole.values()}"
                  value="${user?.role}"/>
    </li>

</fieldset>