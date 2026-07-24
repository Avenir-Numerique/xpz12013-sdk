# FlowType

- `CustomerInvoice`: a non-self-billed outgoing invoice or a self-billed incoming invoice - `SupplierInvoice`: a non-self-billed incoming invoice or self-billed outgoing invoice - `CustomerInvoiceLC`: a lifecycle (CDAR) related to a customer invoice - `SupplierInvoiceLC`: a lifecycle (CDAR) related to supplier invoice - `StateCustomerInvoiceLC`: a customer invoice LC sent to DFH - `StateSupplierInvoiceLC`: a supplier invoice LC sent to DFH - `AggregatedCustomerTransactionReport` : a transaction e-reporting flow containing aggregated B2C sales (FRR 10.3) - `UnitaryCustomerTransactionReport`: a transaction e-reporting flow containing international B2B sales or a B2C transaction flow reported individually (FRR 10.1) - `AggregatedCustomerPaymentReport` : an e-reporting of collections flow containing collections linked to B2C sales (FRR 10.4) - `UnitaryCustomerPaymentReport` : an e-reporting of collections flow containing collections linked to unit international B2B sales or B2C sales (FRR 10.2) - `UnitarySupplierTransactionReport`: a transaction e-reporting flow containing international B2B purchases (FRR 10.1) - `MultiFlowReport`: an e-reporting flow which contains at least 2 different flow types (FRR 10) - `StateCustomerInvoice` : a reporting flow 1 sent to DFH related to an invoice of type ‘CustomerInvoice’ - `StateSupplierInvoice` : a reporting flow 1 sent to DFH related to an invoice of type ‘SupplierInvoice’ for self-billing - `StateTransactionReport` : a transaction e-reporting flow 10.1 or 10.3 sent to the DFH - `StateTransactionReportLC` : a lifecycle for a StateTransactionReport flow - `StatePaymentReport` : a payment e-reporting flow 10.2 or 10.4 sent to DFH - `StatePaymentReportLC` : a lifecycle for a StatePaymentReport flow - `Undefined`            : Not yet defined when in Pending state or unable to define when in Error state 

## Enum

* `CUSTOMERINVOICE` (value: `'CustomerInvoice'`)

* `SUPPLIERINVOICE` (value: `'SupplierInvoice'`)

* `CUSTOMERINVOICELC` (value: `'CustomerInvoiceLC'`)

* `SUPPLIERINVOICELC` (value: `'SupplierInvoiceLC'`)

* `STATECUSTOMERINVOICELC` (value: `'StateCustomerInvoiceLC'`)

* `STATESUPPLIERINVOICELC` (value: `'StateSupplierInvoiceLC'`)

* `AGGREGATEDCUSTOMERTRANSACTIONREPORT` (value: `'AggregatedCustomerTransactionReport'`)

* `UNITARYCUSTOMERTRANSACTIONREPORT` (value: `'UnitaryCustomerTransactionReport'`)

* `AGGREGATEDCUSTOMERPAYMENTREPORT` (value: `'AggregatedCustomerPaymentReport'`)

* `UNITARYCUSTOMERPAYMENTREPORT` (value: `'UnitaryCustomerPaymentReport'`)

* `UNITARYSUPPLIERTRANSACTIONREPORT` (value: `'UnitarySupplierTransactionReport'`)

* `MULTIFLOWREPORT` (value: `'MultiFlowReport'`)

* `STATECUSTOMERINVOICE` (value: `'StateCustomerInvoice'`)

* `STATESUPPLIERINVOICE` (value: `'StateSupplierInvoice'`)

* `STATETRANSACTIONREPORT` (value: `'StateTransactionReport'`)

* `STATETRANSACTIONREPORTLC` (value: `'StateTransactionReportLC'`)

* `STATEPAYMENTREPORT` (value: `'StatePaymentReport'`)

* `STATEPAYMENTREPORTLC` (value: `'StatePaymentReportLC'`)

* `UNDEFINED` (value: `'Undefined'`)

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


