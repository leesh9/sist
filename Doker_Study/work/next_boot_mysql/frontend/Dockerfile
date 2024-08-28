FROM node:20-alpine as builder

WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY ./ ./
CMD ["npm", "run", "dev"]

# FROM nginx:latest
# COPY --from=builder /usr/src/app/.next /usr/share/nginx/html
# COPY --from=builder /usr/src/app/public /usr/share/nginx/html
# COPY ./default.conf /etc/nginx/conf.d/default.conf
# EXPOSE 80
# CMD ["nginx", "-g", "daemon off;"]




