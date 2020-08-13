package org.acme.mongodb.panache

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.PanacheMongoEntity
import io.quarkus.runtime.annotations.RegisterForReflection
import org.bson.codecs.pojo.annotations.BsonProperty
import java.time.LocalDateTime

@RegisterForReflection
@MongoEntity(collection = "people")
@JsonNaming(SnakeCaseStrategy::class)
data class Person(
        var name: String,

        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        @field: BsonProperty("birth_date")
        var birthDate: LocalDateTime? = LocalDateTime.now(),

        var status: Status
) : PanacheMongoEntity()

enum class Status {
    ALIVE, DEAD
}
