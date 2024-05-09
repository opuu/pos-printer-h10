import Foundation

@objc public class POSH10: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
