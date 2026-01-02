# Incident AI – Spring Boot + LLM

A Spring Boot application that summarizes telecom incidents using a Large Language Model (LLM).

The service converts raw incident descriptions into a structured response containing:
- Summary
- Impact analysis
- Impacted systems
- Recommended next actions

This project focuses on clean backend architecture and safe LLM integration.

---

## Tech Stack
- Java 17
- Spring Boot
- REST API
- External LLM (config-driven)
- Jackson (JSON parsing)

---

## High-Level Architecture

Controller → Service → PromptBuilder → LLMClient

- **PromptBuilder**: Builds a structured prompt from incident data  
- **LLMClient**: Handles external LLM API calls (via RestTemplate)  
- **Service**: Orchestrates flow and maps AI output to domain response  

---

## Example Use Case

**Input:**  
Raw telecom incident description (severity, domain, context)

**Output:**  
Structured incident summary with impact and recommended actions

---

## Configuration & Security

- LLM configuration is externalized via Spring profiles
- Secrets (API keys) are **not committed** to source control
- Local development uses `application-local.properties`

---

## Status

v1 – End-to-end working LLM integration  
Added exception handling and unit test case .
Further improvements planned (robust parsing, error handling, observability)
