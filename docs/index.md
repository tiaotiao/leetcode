{% for post in site.posts %}
* [{{ post.title }}](#{{ post.title | downcase | replace: " ", "-" | remove: "'" }})  {% endfor %}

{% for post in site.posts %}

<!--title-->
# {{ post.title }}

<!--subtitle-->
<!--
{% assign date =  post.date | split: " " %}
**Date:** {{ date[0] }}
-->
{% assign seperator = true %}
{% for tag in post.tags %} `{{tag}}` {% endfor %} 

---

<!--post-->
{{ post.excerpt }}

[Top](#header_wrap)

{% endfor %}
