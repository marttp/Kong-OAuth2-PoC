FROM kong
USER root

COPY kong.conf /etc/kong/

RUN git clone https://github.com/wshirey/kong-plugin-jwt-claims-headers \
    && cd kong-plugin-jwt-claims-headers \
    && luarocks make

USER kong