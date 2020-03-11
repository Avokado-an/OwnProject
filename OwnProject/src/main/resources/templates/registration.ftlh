<#import "parts/basic.ftlh" as c>
<#import "parts/loginhelper.ftlh" as l>

<@c.page>
    ${message!"Add new user"}
    <@l.loginsample "/registration" true />
</@c.page>