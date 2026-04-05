run:
	./gradlew run

package:
	./gradlew distTar

build:
	./gradlew --no-daemon shadowJar

test:
	./gradlew test