# Spring Server monitoring

## ๐๐ป Goal
### Let's check health of our springboot server!


## Version
- SpringBoot : 2.4.4
- Java : 11

### About Spring Boot 2.x Actuator
In 2.x, Actuator keeps its fundamental intent but simplifies its model, extends its capabilities, and incorporates better defaults.
First, this version becomes technology-agnostic. It also simplifies its security model by merging it with the application one.
Among the various changes, it's important to keep in mind that some of them are breaking. This includes HTTP requests and responses as well as Java APIs.
Lastly, the latest version now supports the CRUD model as opposed to the old read/write model.

<br>

- BaseURL
```
http://localhost:8080/actuator
```

## /health

- ์ดํ๋ฆฌ์ผ์ด์์ ๋ํ ๊ธฐ๋ณธ์ ์ธ ์ ๋ณด๋ฅผ ์ ๊ณต
- Status
    - Up : ์๋ฒ ์ ์
    - Down : DB ์ฐ๊ฒฐ ๋ฌธ์ , ๋๋ ๋์คํฌ ๊ณต๊ฐ ๋ถ์กฑ
```
http://localhost:8080/actuator/health
```

## /metrics
```
http://localhost:8080/actuator/metrics
```
- JVM memory ์ฌ์ฉ๋ฅ 
- CPU usage
- ๋ฉํธ๋ฆญ์์ ์ ๊ณตํด์ฃผ๋ ๊ธฐ๋ฅ๋ค์ ๋ง๋ค. ์ํ๋ ๋ฉํธ๋ฆญ์ checkํ  ์ ์๋ค.
- ์๋ฅผ ๋ค๋ฉด ๋ค์๊ณผ ๊ฐ๋ค.
 ```
 http://localhost:8080/actuator/metrics/jvm.buffer.memory.used
 ```


## /loggers
- Application log ํ์ธ
- Runtime์์ ์ log level์ ๋ฐ๊ฟ ์๋ ์์
```
http://localhost:8080/actuator/loggers
```

## /info
```
http://localhost:8080/actuator/info
```

## /shutdown
- ๊ธฐ๋ณธ์ ์ผ๋ก๋ false๋ก ์ค์ ๋์ด ์์
- shutdown ์๋ํฌ์ธํธ๋ ๋ณด์์ด ์ค์.
- ๋ง์ฝ ๋ธ์ถํ๋ค๋ฉด ๊ผญ ๋ณด์์ ์ค์ ํ  ๊ฒ(SpringSecurity)

### ๊ทธ ์ธ์ ๋ค์ํ ๊ธฐ๋ฅ๋ค

Unlike in previous versions, Actuator comes with most endpoints disabled.
Thus, the only two available by default are /health and /info.
If we want to enable all of them, we could set management.endpoints.web.exposure.include=*. Alternatively, we can list endpoints that should be enabled.

Spec์ ๋ํด ์กฐ์ฌํ๊ณ  ์ฌ์ฉํ  ๊ฒ(์ฌ์ฉ๋ฒ์ด ๋ค ๋ค๋ฆ)
<br/>

- `/auditevents` lists security audit-related events such as user login/logout. Also, we can filter by principal or type among other fields.
- `/beans` returns all available beans in our BeanFactory. Unlike `/auditevents`, it doesn't support filtering.
- `/conditions`, formerly known as `/autoconfig`, builds a report of conditions around autoconfiguration.
- `/configprops` allows us to fetch all @ConfigurationProperties beans.
- `/env` returns the current environment properties. Additionally, we can retrieve single properties.
- `/flyway` provides details about our Flyway database migrations.
- `/health` summarizes the health status of our application.
- `/heapdump` builds and returns a heap dump from the JVM used by our application.
- `/info` returns general information. It might be custom data, build information or details about the latest commit.
- `/liquibase` behaves like /flyway but for Liquibase.
- `/logfile` returns ordinary application logs.
- `/loggers` enables us to query and modify the logging level of our application.
- `/metrics` details metrics of our application. This might include generic metrics as well as custom ones.
- `/prometheus` returns metrics like the previous one, but formatted to work with a Prometheus server.
- `/scheduledtasks` provides details about every scheduled task within our application.
- `/sessions` lists HTTP sessions given we are using Spring Session.
- `/shutdown` performs a graceful shutdown of the application.
- `/threaddump` dumps the thread information of the underlying JVM.