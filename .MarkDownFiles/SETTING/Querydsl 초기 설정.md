# Querydsl 초기 설정
## build.gradle
- 다음 코드 추가 삽입
```build.gradle
buildscript {
	// queryDslVersion 버전추가
	ext {
		queryDslVersion = "5.0.0"
	}
}

plugins {
	//querydsl 추가
	id "com.ewerk.gradle.plugins.querydsl" version "1.0.10"
}

dependencies {
	//querydsl 추가
	implementation "com.querydsl:querydsl-jpa:${queryDslVersion}"
	implementation "com.querydsl:querydsl-apt:${queryDslVersion}"
}

/querydsl 추가 시작/
def querydslDir = "$buildDir/generated/querydsl"

querydsl {
	jpa = true
	querydslSourcesDir = querydslDir
}
sourceSets {
	main.java.srcDir querydslDir
}
compileQuerydsl{
	options.annotationProcessorPath = configurations.querydsl
}
configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
	querydsl.extendsFrom compileClasspath
}
/querydsl 추가 끝/
```
