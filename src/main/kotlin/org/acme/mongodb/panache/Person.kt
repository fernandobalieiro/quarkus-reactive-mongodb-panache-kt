package org.acme.mongodb.panache

import com.fasterxml.jackson.annotation.JsonFormat
import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.PanacheMongoEntity
import io.quarkus.runtime.annotations.RegisterForReflection
import java.time.LocalDateTime

@RegisterForReflection
@MongoEntity(collection = "people")
data class Person(
        var name: String,
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        var birthDate: LocalDateTime? = LocalDateTime.now(),
        var status: Status
) : PanacheMongoEntity()

enum class Status {
    ALIVE, DEAD
}
