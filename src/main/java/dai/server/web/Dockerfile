FROM nginx
RUN rm /etc/nginx/conf.d/default.conf
COPY ./mywebsite /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/