# 스프링 공부

2022년 여름 **초보 웹 개발자를 위한 스프링5 프로그래밍 입문** 책을 통해 공부 진행.

각각의 장에 대한 내용을 .md파일로 정리해놓음

스프링 부트를 사용하기 위해 진행하는 공부이기 때문에 JSP 관련 부분들은 스킵한다.

<br>
<br>


## 챕터별 내용 및 키워드

2. [**Chapter02 스프링 시작하기**](chapter02_%EC%8A%A4%ED%94%84%EB%A7%81_%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0.md)<br>
    * `@Bean` 
    * 스프링 컨테이너(IoC 컨테이너)
    * 싱글톤 범위
3. [**Chapter03 스프링 DI**](chapter03_%20스프링_DI.md)<br>
    * DI(Dependency Injection, 의존 주입)
    * `@Configuration`
    * `@Bean` 싱글톤
    * `@Autowired` 대략 설명
    * `@Imoport`
4. [**chapter04 의존 자동 주입**](chapter04_%EC%9D%98%EC%A1%B4_%EC%9E%90%EB%8F%99_%EC%A3%BC%EC%9E%85.md)<br>
    * `@Autowired`
    * `@Qualifier`
    * `@Autowired`속성: `required`
    * `Optional`
    * `@Nullable`
    * 생성자 `@Autowired`, 세터 `@Autowired`
5. [**chapter05 컴포넌트 스캔**](chapter05_%EC%BB%B4%ED%8F%AC%EB%84%8C%ED%8A%B8_%EC%8A%A4%EC%BA%94.md)<br>
    * `@Component`
    * `@ComponentScan`
    * `@ComponentScan` 속성: `basePackages`, `excludeFilters`
    * 컴포넌트 스캔 대상
    * 컴포넌트 충돌 처리
6. [**chapter06 빈 라이프사이클과 범위**](chapter06_%EB%B9%88_%EB%9D%BC%EC%9D%B4%ED%94%84%EC%82%AC%EC%9D%B4%ED%81%B4%EA%B3%BC_%EB%B2%94%EC%9C%84.md)<br>
    * 스프링 컨테이너 라이프사이클
    * 빈 객체의 라이프사이클
    * `InitializingBean`,`DisposableBean`
    * `@Bean` 속성: `initMethod`, `destroyMethod`
    * `@Scope`
7. [**chapter07 AOP 프로그래밍**](https://velog.io/@sdsd0908/Spring-AOP)<br>
8. [**chapter08 DB 연동**](chapter08_DB_%EC%97%B0%EB%8F%99.md)<br>
    * 커넥션 풀
    * `DataSource` 설정
    * 트랜잭션
    * `@Transactional`
9. [**chapter09 스프링 MVC 시작하기**](chapter09_%EC%8A%A4%ED%94%84%EB%A7%81_MVC_%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0.md)<br>
    * Maven, Gradle에서의 WEB-INF
    * `@Controller`
    * `@SpringBootApplication`(책 이외)
    * `@EnableAutoConfiguration`(책 이외)
    * `@RestController` 내용 약간(책 이외)
10. [**chapter10 스프링 MVC 프레임워크 동작 방식**](chapter10_%EC%8A%A4%ED%94%84%EB%A7%81_MVC_%ED%94%84%EB%A0%88%EC%9E%84%EC%9B%8C%ED%81%AC_%EB%8F%99%EC%9E%91_%EB%B0%A9%EC%8B%9D.md)<br>
    * `DispatcherServlet` 동작 원리
    * `HandlerMapping` 
    * `HandlerAdapter`
    * `ViewResolver`
11. [**chapter11 MVC1: 요청 매핑, 커맨드 객체, 리다이렉트, 폼 태그, 모델**](chapter11_MVC1.md)<br>
    * 요청 매핑 애노테이션: `@RequestMapping`, `@GetMapping`, `@PostMapping`
    * `HttpServletRequest`, `@RequestParam`
    * `@RequestParam`의 속성들
    * 리다이렉트
    * 커맨드 객체
    * `Model`, `ModelAndView`
12. [**~~chapter12 MVC2~~**](chapter12_MVC2.md)<br>
13. [**chapter13 MVC3: 세션, 인터셉터, 쿠키**](chapter13_MVC3.md)<br>
    * `HttpSession`
    * `HandlerInterceptor`
    * 쿠키
    * HandlerInterceptor 이외 공통 처리(책 이외)
14. . <br>
15. [**chapter15 간단한 웹 어플리케이션의 구조**](chapter15_%EA%B0%84%EB%8B%A8%ED%95%9C_%EC%9B%B9_%EC%96%B4%ED%94%8C%EB%A6%AC%EC%BC%80%EC%9D%B4%EC%85%98%EC%9D%98_%EA%B5%AC%EC%A1%B0.md)<br>
    * 웹 어플리케이션 구조(컨트롤러, 서비스, DAO)
    * 패키지 구성
    * 도메인 주도 설계(약간 나옴)
    * 도메인(책 이외)
16. . <br>
17. [**chapter17 프로필과 프로퍼티 파일**](chapter17_%ED%94%84%EB%A1%9C%ED%95%84%EA%B3%BC_%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0_%ED%8C%8C%EC%9D%BC.md)<br>
    * `@Profile`

<br>
<br>

[책 내용 혼자 적용하면서 발생한 오류](source_code/demo/src/main/java/com/example/demo/toyprj/README.md)


인터셉터는 스프링부프 시큐리티 [selfPrj](../Springboot%20%EC%8B%9C%ED%81%90%EB%A6%AC%ED%8B%B0/src/selfPrj/)에서 적용했다.
<br>

