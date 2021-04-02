# Spring Server monitoring

## 👉🏻 Goal
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

- 어플리케이션에 대한 기본적인 정보를 제공
- Status
    - Up : 서버 정상
    - Down : DB 연결 문제, 또는 디스크 공간 부족
```
http://localhost:8080/actuator/health
```

## /metrics
```
http://localhost:8080/actuator/metrics
```
- JVM memory 사용률
- CPU usage
- 메트릭에서 제공해주는 기능들은 많다. 원하는 메트릭을 check할 수 있다.
- 예를 들면 다음과 같다.
 ```
 http://localhost:8080/actuator/metrics/jvm.buffer.memory.used
 ```


## /loggers
- Application log 확인
- Runtime시점에 log level을 바꿀 수도 있음
```
http://localhost:8080/actuator/loggers
```

## /info
```
http://localhost:8080/actuator/info
```

## /shutdown
- 기본적으로는 false로 설정되어 있음
- shutdown 엔드포인트는 보안이 중요.
- 만약 노출한다면 꼭 보안을 설정할 것(SpringSecurity)

### 그 외의 다양한 기능들

Unlike in previous versions, Actuator comes with most endpoints disabled.
Thus, the only two available by default are /health and /info.
If we want to enable all of them, we could set management.endpoints.web.exposure.include=*. Alternatively, we can list endpoints that should be enabled.

Spec에 대해 조사하고 사용할 것(사용법이 다 다름)
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