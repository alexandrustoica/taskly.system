package taskly.system.report

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason="404 The report was not found by the system!")
class ReportNotFound : RuntimeException("Report Not Found!")