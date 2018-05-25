<!--
{% for post in site.posts %}

[{{ post.title }}](#{{ post.title | downcase | replace: " ", "-" | remove: "'" }})

{% endfor %}
-->

{% for post in site.posts %}

## {{ post.title }}

{{ post.excerpt }}

{% endfor %}
