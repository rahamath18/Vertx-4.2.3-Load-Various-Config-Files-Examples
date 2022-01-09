package com.test.vertx423.configfiles;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;

public class LoadVariousConfigFiles extends AbstractVerticle {

	// Convenience method so you can run it in your IDE
	public static void main(String[] args) {
		System.out.println("welcome to Load Various Config Files Example");
		Runner.runExample(LoadVariousConfigFiles.class);
	}

	@Override
	public void start() throws Exception {

		ConfigRetrieverOptions options = new ConfigRetrieverOptions();
		
		options.addStore(new ConfigStoreOptions().setType("file").setFormat("properties")
				.setConfig(new JsonObject().put("path", "application.properties")));

		options.addStore(new ConfigStoreOptions().setType("file").setFormat("json")
				.setConfig(new JsonObject().put("path", "conf/server-detail.json")));

		options.addStore(new ConfigStoreOptions().setType("sys"));

//		options.addStore(new ConfigStoreOptions().setType("http")
//				.setConfig(new JsonObject().put("host", "localhost").put("port", 8080).put("path", "/conf")));

		// hocon file support properties file format
		options.addStore(new ConfigStoreOptions().setType("file").setFormat("hocon")
				.setConfig(new JsonObject().put("path", "db.hocon")));
		
		// hocon file support json file format
		options.addStore(new ConfigStoreOptions().setType("file").setFormat("hocon")
				.setConfig(new JsonObject().put("path", "config.hocon")));
		
		// hocon file support json file format
		options.addStore(new ConfigStoreOptions().setType("file").setFormat("hocon")
				.setConfig(new JsonObject().put("path", "query.hocon")));
		
		options.addStore(new ConfigStoreOptions()
				  .setType("file")
				  .setFormat("yaml")
				  .setConfig(new JsonObject()
				    .put("path", "spring.application.yaml")
				  ));
		
//		try {
//			options.addStore(new ConfigStoreOptions()
//				    .setType("git")
//				    .setConfig(new JsonObject()
//				        .put("url", "https://github.com/rahamath18/Hibernate-6.0.0.Beta3-Jakarta-Persistence-3.0.0-Java-17-Example/tree/main/src/main/resources.git")
//				        .put("path", "remote")
//				        .put("filesets", new JsonArray().add(new JsonObject().put("pattern", "*.properties")))
//				        .put("user", "")
//				        .put("password", "")
//				        ));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		print(options);

	}

	public Future<JsonObject> ReadAsynchronously(ConfigRetrieverOptions options) {
		Promise<JsonObject> promise = Promise.promise();
		ConfigRetriever retriever = ConfigRetriever.create(vertx, options);
		retriever.getConfig(ar -> {
			if (ar.succeeded()) {
				JsonObject jo = ar.result();
				promise.complete(jo);
			} else {
				promise.fail(ar.cause());
			}
		});

		return promise.future();
	}

	private void print(ConfigRetrieverOptions options) {
		System.out.println("ConfigRetrieverOptions " + options.toJson());
//		System.out.println("ConfigRetrieverOptions " + options.toJson().encodePrettily());
		ReadAsynchronously(options).onComplete((AsyncResult<JsonObject> handler) -> {
			if (handler.succeeded()) {
				System.out.println("File Content\n " + handler.result().encodePrettily());
			} else if (handler.failed()) {
				System.out.println("Failed calling ReadAsynchronously()");
			}
		});
	}
}
