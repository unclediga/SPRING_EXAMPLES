<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<div>
    <@l.logout/>
</div>
<div>
    <form method="post" action="main">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="text" name="text" placeholder="Введите текст"/>
        <input type="text" name="tag" placeholder="Введите тег"/>
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список сообщений</div>
<div>
    <form method="post" action="filter">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="text" name="filter"/>
        <button type="submit">Найти</button>
    </form>
</div>
<#list messages  as message>
    <div>
        <b>${message.id}</b>
        <span>${message.text}</span>
        <i>${message.tag}</i>
        <strong>${message.authorName}</strong>
    </div>
<#else >
    No Messages
</#list>
</@c.page>